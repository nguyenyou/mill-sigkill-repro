package generated

final case class Data815(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data815 = copy(name = name.toUpperCase)
  def scale(k: Double): Data815 = copy(value = value * k)
  def addTag(t: String): Data815 = copy(tags = t :: tags)
  def put(k: String, v: String): Data815 = copy(meta = meta.updated(k, v))
  def merge(other: Data815): Data815 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data815 {
  given Ordering[Data815] = Ordering.by(_.id)
  def empty: Data815 = Data815(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data815 =
    Data815(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data815] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
