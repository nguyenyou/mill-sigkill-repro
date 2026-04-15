package generated

final case class Data879(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data879 = copy(name = name.toUpperCase)
  def scale(k: Double): Data879 = copy(value = value * k)
  def addTag(t: String): Data879 = copy(tags = t :: tags)
  def put(k: String, v: String): Data879 = copy(meta = meta.updated(k, v))
  def merge(other: Data879): Data879 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data879 {
  given Ordering[Data879] = Ordering.by(_.id)
  def empty: Data879 = Data879(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data879 =
    Data879(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data879] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
