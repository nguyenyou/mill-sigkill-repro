package generated

final case class Data147(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data147 = copy(name = name.toUpperCase)
  def scale(k: Double): Data147 = copy(value = value * k)
  def addTag(t: String): Data147 = copy(tags = t :: tags)
  def put(k: String, v: String): Data147 = copy(meta = meta.updated(k, v))
  def merge(other: Data147): Data147 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data147 {
  given Ordering[Data147] = Ordering.by(_.id)
  def empty: Data147 = Data147(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data147 =
    Data147(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data147] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
