package generated

final case class Data304(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data304 = copy(name = name.toUpperCase)
  def scale(k: Double): Data304 = copy(value = value * k)
  def addTag(t: String): Data304 = copy(tags = t :: tags)
  def put(k: String, v: String): Data304 = copy(meta = meta.updated(k, v))
  def merge(other: Data304): Data304 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data304 {
  given Ordering[Data304] = Ordering.by(_.id)
  def empty: Data304 = Data304(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data304 =
    Data304(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data304] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
