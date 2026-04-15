package generated

final case class Data414(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data414 = copy(name = name.toUpperCase)
  def scale(k: Double): Data414 = copy(value = value * k)
  def addTag(t: String): Data414 = copy(tags = t :: tags)
  def put(k: String, v: String): Data414 = copy(meta = meta.updated(k, v))
  def merge(other: Data414): Data414 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data414 {
  given Ordering[Data414] = Ordering.by(_.id)
  def empty: Data414 = Data414(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data414 =
    Data414(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data414] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
