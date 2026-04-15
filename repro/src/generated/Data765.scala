package generated

final case class Data765(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data765 = copy(name = name.toUpperCase)
  def scale(k: Double): Data765 = copy(value = value * k)
  def addTag(t: String): Data765 = copy(tags = t :: tags)
  def put(k: String, v: String): Data765 = copy(meta = meta.updated(k, v))
  def merge(other: Data765): Data765 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data765 {
  given Ordering[Data765] = Ordering.by(_.id)
  def empty: Data765 = Data765(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data765 =
    Data765(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data765] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
