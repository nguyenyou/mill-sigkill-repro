package generated

final case class Data809(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data809 = copy(name = name.toUpperCase)
  def scale(k: Double): Data809 = copy(value = value * k)
  def addTag(t: String): Data809 = copy(tags = t :: tags)
  def put(k: String, v: String): Data809 = copy(meta = meta.updated(k, v))
  def merge(other: Data809): Data809 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data809 {
  given Ordering[Data809] = Ordering.by(_.id)
  def empty: Data809 = Data809(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data809 =
    Data809(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data809] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
