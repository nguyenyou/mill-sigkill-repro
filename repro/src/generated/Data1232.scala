package generated

final case class Data1232(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1232 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1232 = copy(value = value * k)
  def addTag(t: String): Data1232 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1232 = copy(meta = meta.updated(k, v))
  def merge(other: Data1232): Data1232 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1232 {
  given Ordering[Data1232] = Ordering.by(_.id)
  def empty: Data1232 = Data1232(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1232 =
    Data1232(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1232] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
