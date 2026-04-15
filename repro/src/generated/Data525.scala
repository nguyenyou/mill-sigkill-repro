package generated

final case class Data525(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data525 = copy(name = name.toUpperCase)
  def scale(k: Double): Data525 = copy(value = value * k)
  def addTag(t: String): Data525 = copy(tags = t :: tags)
  def put(k: String, v: String): Data525 = copy(meta = meta.updated(k, v))
  def merge(other: Data525): Data525 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data525 {
  given Ordering[Data525] = Ordering.by(_.id)
  def empty: Data525 = Data525(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data525 =
    Data525(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data525] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
