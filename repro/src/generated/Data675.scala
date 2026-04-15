package generated

final case class Data675(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data675 = copy(name = name.toUpperCase)
  def scale(k: Double): Data675 = copy(value = value * k)
  def addTag(t: String): Data675 = copy(tags = t :: tags)
  def put(k: String, v: String): Data675 = copy(meta = meta.updated(k, v))
  def merge(other: Data675): Data675 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data675 {
  given Ordering[Data675] = Ordering.by(_.id)
  def empty: Data675 = Data675(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data675 =
    Data675(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data675] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
