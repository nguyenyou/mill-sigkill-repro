package generated

final case class Data551(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data551 = copy(name = name.toUpperCase)
  def scale(k: Double): Data551 = copy(value = value * k)
  def addTag(t: String): Data551 = copy(tags = t :: tags)
  def put(k: String, v: String): Data551 = copy(meta = meta.updated(k, v))
  def merge(other: Data551): Data551 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data551 {
  given Ordering[Data551] = Ordering.by(_.id)
  def empty: Data551 = Data551(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data551 =
    Data551(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data551] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
