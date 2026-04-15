package generated

final case class Data826(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data826 = copy(name = name.toUpperCase)
  def scale(k: Double): Data826 = copy(value = value * k)
  def addTag(t: String): Data826 = copy(tags = t :: tags)
  def put(k: String, v: String): Data826 = copy(meta = meta.updated(k, v))
  def merge(other: Data826): Data826 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data826 {
  given Ordering[Data826] = Ordering.by(_.id)
  def empty: Data826 = Data826(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data826 =
    Data826(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data826] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
