package generated

final case class Data398(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data398 = copy(name = name.toUpperCase)
  def scale(k: Double): Data398 = copy(value = value * k)
  def addTag(t: String): Data398 = copy(tags = t :: tags)
  def put(k: String, v: String): Data398 = copy(meta = meta.updated(k, v))
  def merge(other: Data398): Data398 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data398 {
  given Ordering[Data398] = Ordering.by(_.id)
  def empty: Data398 = Data398(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data398 =
    Data398(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data398] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
