package generated

final case class Data392(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data392 = copy(name = name.toUpperCase)
  def scale(k: Double): Data392 = copy(value = value * k)
  def addTag(t: String): Data392 = copy(tags = t :: tags)
  def put(k: String, v: String): Data392 = copy(meta = meta.updated(k, v))
  def merge(other: Data392): Data392 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data392 {
  given Ordering[Data392] = Ordering.by(_.id)
  def empty: Data392 = Data392(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data392 =
    Data392(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data392] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
