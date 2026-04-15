package generated

final case class Data1016(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1016 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1016 = copy(value = value * k)
  def addTag(t: String): Data1016 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1016 = copy(meta = meta.updated(k, v))
  def merge(other: Data1016): Data1016 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1016 {
  given Ordering[Data1016] = Ordering.by(_.id)
  def empty: Data1016 = Data1016(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1016 =
    Data1016(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1016] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
