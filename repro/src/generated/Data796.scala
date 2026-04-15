package generated

final case class Data796(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data796 = copy(name = name.toUpperCase)
  def scale(k: Double): Data796 = copy(value = value * k)
  def addTag(t: String): Data796 = copy(tags = t :: tags)
  def put(k: String, v: String): Data796 = copy(meta = meta.updated(k, v))
  def merge(other: Data796): Data796 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data796 {
  given Ordering[Data796] = Ordering.by(_.id)
  def empty: Data796 = Data796(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data796 =
    Data796(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data796] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
