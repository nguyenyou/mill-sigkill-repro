package generated

final case class Data651(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data651 = copy(name = name.toUpperCase)
  def scale(k: Double): Data651 = copy(value = value * k)
  def addTag(t: String): Data651 = copy(tags = t :: tags)
  def put(k: String, v: String): Data651 = copy(meta = meta.updated(k, v))
  def merge(other: Data651): Data651 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data651 {
  given Ordering[Data651] = Ordering.by(_.id)
  def empty: Data651 = Data651(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data651 =
    Data651(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data651] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
