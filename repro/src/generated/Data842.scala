package generated

final case class Data842(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data842 = copy(name = name.toUpperCase)
  def scale(k: Double): Data842 = copy(value = value * k)
  def addTag(t: String): Data842 = copy(tags = t :: tags)
  def put(k: String, v: String): Data842 = copy(meta = meta.updated(k, v))
  def merge(other: Data842): Data842 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data842 {
  given Ordering[Data842] = Ordering.by(_.id)
  def empty: Data842 = Data842(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data842 =
    Data842(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data842] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
