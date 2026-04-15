package generated

final case class Data541(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data541 = copy(name = name.toUpperCase)
  def scale(k: Double): Data541 = copy(value = value * k)
  def addTag(t: String): Data541 = copy(tags = t :: tags)
  def put(k: String, v: String): Data541 = copy(meta = meta.updated(k, v))
  def merge(other: Data541): Data541 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data541 {
  given Ordering[Data541] = Ordering.by(_.id)
  def empty: Data541 = Data541(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data541 =
    Data541(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data541] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
