package generated

final case class Data48(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data48 = copy(name = name.toUpperCase)
  def scale(k: Double): Data48 = copy(value = value * k)
  def addTag(t: String): Data48 = copy(tags = t :: tags)
  def put(k: String, v: String): Data48 = copy(meta = meta.updated(k, v))
  def merge(other: Data48): Data48 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data48 {
  given Ordering[Data48] = Ordering.by(_.id)
  def empty: Data48 = Data48(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data48 =
    Data48(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data48] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
