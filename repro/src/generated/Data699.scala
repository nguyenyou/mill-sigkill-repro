package generated

final case class Data699(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data699 = copy(name = name.toUpperCase)
  def scale(k: Double): Data699 = copy(value = value * k)
  def addTag(t: String): Data699 = copy(tags = t :: tags)
  def put(k: String, v: String): Data699 = copy(meta = meta.updated(k, v))
  def merge(other: Data699): Data699 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data699 {
  given Ordering[Data699] = Ordering.by(_.id)
  def empty: Data699 = Data699(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data699 =
    Data699(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data699] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
