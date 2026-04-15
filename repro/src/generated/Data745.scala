package generated

final case class Data745(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data745 = copy(name = name.toUpperCase)
  def scale(k: Double): Data745 = copy(value = value * k)
  def addTag(t: String): Data745 = copy(tags = t :: tags)
  def put(k: String, v: String): Data745 = copy(meta = meta.updated(k, v))
  def merge(other: Data745): Data745 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data745 {
  given Ordering[Data745] = Ordering.by(_.id)
  def empty: Data745 = Data745(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data745 =
    Data745(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data745] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
