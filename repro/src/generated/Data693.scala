package generated

final case class Data693(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data693 = copy(name = name.toUpperCase)
  def scale(k: Double): Data693 = copy(value = value * k)
  def addTag(t: String): Data693 = copy(tags = t :: tags)
  def put(k: String, v: String): Data693 = copy(meta = meta.updated(k, v))
  def merge(other: Data693): Data693 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data693 {
  given Ordering[Data693] = Ordering.by(_.id)
  def empty: Data693 = Data693(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data693 =
    Data693(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data693] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
