package generated

final case class Data850(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data850 = copy(name = name.toUpperCase)
  def scale(k: Double): Data850 = copy(value = value * k)
  def addTag(t: String): Data850 = copy(tags = t :: tags)
  def put(k: String, v: String): Data850 = copy(meta = meta.updated(k, v))
  def merge(other: Data850): Data850 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data850 {
  given Ordering[Data850] = Ordering.by(_.id)
  def empty: Data850 = Data850(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data850 =
    Data850(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data850] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
