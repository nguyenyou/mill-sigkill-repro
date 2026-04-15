package generated

final case class Data318(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data318 = copy(name = name.toUpperCase)
  def scale(k: Double): Data318 = copy(value = value * k)
  def addTag(t: String): Data318 = copy(tags = t :: tags)
  def put(k: String, v: String): Data318 = copy(meta = meta.updated(k, v))
  def merge(other: Data318): Data318 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data318 {
  given Ordering[Data318] = Ordering.by(_.id)
  def empty: Data318 = Data318(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data318 =
    Data318(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data318] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
