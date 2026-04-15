package generated

final case class Data632(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data632 = copy(name = name.toUpperCase)
  def scale(k: Double): Data632 = copy(value = value * k)
  def addTag(t: String): Data632 = copy(tags = t :: tags)
  def put(k: String, v: String): Data632 = copy(meta = meta.updated(k, v))
  def merge(other: Data632): Data632 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data632 {
  given Ordering[Data632] = Ordering.by(_.id)
  def empty: Data632 = Data632(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data632 =
    Data632(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data632] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
