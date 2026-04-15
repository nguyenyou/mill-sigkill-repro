package generated

final case class Data742(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data742 = copy(name = name.toUpperCase)
  def scale(k: Double): Data742 = copy(value = value * k)
  def addTag(t: String): Data742 = copy(tags = t :: tags)
  def put(k: String, v: String): Data742 = copy(meta = meta.updated(k, v))
  def merge(other: Data742): Data742 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data742 {
  given Ordering[Data742] = Ordering.by(_.id)
  def empty: Data742 = Data742(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data742 =
    Data742(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data742] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
