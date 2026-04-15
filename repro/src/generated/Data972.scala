package generated

final case class Data972(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data972 = copy(name = name.toUpperCase)
  def scale(k: Double): Data972 = copy(value = value * k)
  def addTag(t: String): Data972 = copy(tags = t :: tags)
  def put(k: String, v: String): Data972 = copy(meta = meta.updated(k, v))
  def merge(other: Data972): Data972 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data972 {
  given Ordering[Data972] = Ordering.by(_.id)
  def empty: Data972 = Data972(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data972 =
    Data972(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data972] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
