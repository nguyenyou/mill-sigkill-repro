package generated

final case class Data409(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data409 = copy(name = name.toUpperCase)
  def scale(k: Double): Data409 = copy(value = value * k)
  def addTag(t: String): Data409 = copy(tags = t :: tags)
  def put(k: String, v: String): Data409 = copy(meta = meta.updated(k, v))
  def merge(other: Data409): Data409 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data409 {
  given Ordering[Data409] = Ordering.by(_.id)
  def empty: Data409 = Data409(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data409 =
    Data409(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data409] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
