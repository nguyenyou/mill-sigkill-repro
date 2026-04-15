package generated

final case class Data242(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data242 = copy(name = name.toUpperCase)
  def scale(k: Double): Data242 = copy(value = value * k)
  def addTag(t: String): Data242 = copy(tags = t :: tags)
  def put(k: String, v: String): Data242 = copy(meta = meta.updated(k, v))
  def merge(other: Data242): Data242 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data242 {
  given Ordering[Data242] = Ordering.by(_.id)
  def empty: Data242 = Data242(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data242 =
    Data242(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data242] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
