package generated

final case class Data641(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data641 = copy(name = name.toUpperCase)
  def scale(k: Double): Data641 = copy(value = value * k)
  def addTag(t: String): Data641 = copy(tags = t :: tags)
  def put(k: String, v: String): Data641 = copy(meta = meta.updated(k, v))
  def merge(other: Data641): Data641 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data641 {
  given Ordering[Data641] = Ordering.by(_.id)
  def empty: Data641 = Data641(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data641 =
    Data641(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data641] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
