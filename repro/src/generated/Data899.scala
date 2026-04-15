package generated

final case class Data899(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data899 = copy(name = name.toUpperCase)
  def scale(k: Double): Data899 = copy(value = value * k)
  def addTag(t: String): Data899 = copy(tags = t :: tags)
  def put(k: String, v: String): Data899 = copy(meta = meta.updated(k, v))
  def merge(other: Data899): Data899 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data899 {
  given Ordering[Data899] = Ordering.by(_.id)
  def empty: Data899 = Data899(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data899 =
    Data899(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data899] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
