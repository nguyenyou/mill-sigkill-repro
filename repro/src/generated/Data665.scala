package generated

final case class Data665(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data665 = copy(name = name.toUpperCase)
  def scale(k: Double): Data665 = copy(value = value * k)
  def addTag(t: String): Data665 = copy(tags = t :: tags)
  def put(k: String, v: String): Data665 = copy(meta = meta.updated(k, v))
  def merge(other: Data665): Data665 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data665 {
  given Ordering[Data665] = Ordering.by(_.id)
  def empty: Data665 = Data665(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data665 =
    Data665(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data665] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
