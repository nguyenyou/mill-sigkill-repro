package generated

final case class Data902(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data902 = copy(name = name.toUpperCase)
  def scale(k: Double): Data902 = copy(value = value * k)
  def addTag(t: String): Data902 = copy(tags = t :: tags)
  def put(k: String, v: String): Data902 = copy(meta = meta.updated(k, v))
  def merge(other: Data902): Data902 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data902 {
  given Ordering[Data902] = Ordering.by(_.id)
  def empty: Data902 = Data902(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data902 =
    Data902(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data902] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
