package generated

final case class Data274(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data274 = copy(name = name.toUpperCase)
  def scale(k: Double): Data274 = copy(value = value * k)
  def addTag(t: String): Data274 = copy(tags = t :: tags)
  def put(k: String, v: String): Data274 = copy(meta = meta.updated(k, v))
  def merge(other: Data274): Data274 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data274 {
  given Ordering[Data274] = Ordering.by(_.id)
  def empty: Data274 = Data274(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data274 =
    Data274(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data274] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
