package generated

final case class Data1285(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1285 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1285 = copy(value = value * k)
  def addTag(t: String): Data1285 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1285 = copy(meta = meta.updated(k, v))
  def merge(other: Data1285): Data1285 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1285 {
  given Ordering[Data1285] = Ordering.by(_.id)
  def empty: Data1285 = Data1285(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1285 =
    Data1285(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1285] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
