package generated

final case class Data583(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data583 = copy(name = name.toUpperCase)
  def scale(k: Double): Data583 = copy(value = value * k)
  def addTag(t: String): Data583 = copy(tags = t :: tags)
  def put(k: String, v: String): Data583 = copy(meta = meta.updated(k, v))
  def merge(other: Data583): Data583 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data583 {
  given Ordering[Data583] = Ordering.by(_.id)
  def empty: Data583 = Data583(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data583 =
    Data583(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data583] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
