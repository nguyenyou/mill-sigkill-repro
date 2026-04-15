package generated

final case class Data374(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data374 = copy(name = name.toUpperCase)
  def scale(k: Double): Data374 = copy(value = value * k)
  def addTag(t: String): Data374 = copy(tags = t :: tags)
  def put(k: String, v: String): Data374 = copy(meta = meta.updated(k, v))
  def merge(other: Data374): Data374 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data374 {
  given Ordering[Data374] = Ordering.by(_.id)
  def empty: Data374 = Data374(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data374 =
    Data374(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data374] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
