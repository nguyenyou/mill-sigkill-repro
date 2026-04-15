package generated

final case class Data577(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data577 = copy(name = name.toUpperCase)
  def scale(k: Double): Data577 = copy(value = value * k)
  def addTag(t: String): Data577 = copy(tags = t :: tags)
  def put(k: String, v: String): Data577 = copy(meta = meta.updated(k, v))
  def merge(other: Data577): Data577 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data577 {
  given Ordering[Data577] = Ordering.by(_.id)
  def empty: Data577 = Data577(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data577 =
    Data577(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data577] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
