package generated

final case class Data1217(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1217 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1217 = copy(value = value * k)
  def addTag(t: String): Data1217 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1217 = copy(meta = meta.updated(k, v))
  def merge(other: Data1217): Data1217 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1217 {
  given Ordering[Data1217] = Ordering.by(_.id)
  def empty: Data1217 = Data1217(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1217 =
    Data1217(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1217] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
