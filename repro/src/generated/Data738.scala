package generated

final case class Data738(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data738 = copy(name = name.toUpperCase)
  def scale(k: Double): Data738 = copy(value = value * k)
  def addTag(t: String): Data738 = copy(tags = t :: tags)
  def put(k: String, v: String): Data738 = copy(meta = meta.updated(k, v))
  def merge(other: Data738): Data738 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data738 {
  given Ordering[Data738] = Ordering.by(_.id)
  def empty: Data738 = Data738(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data738 =
    Data738(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data738] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
