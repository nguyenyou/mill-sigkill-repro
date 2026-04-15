package generated

final case class Data246(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data246 = copy(name = name.toUpperCase)
  def scale(k: Double): Data246 = copy(value = value * k)
  def addTag(t: String): Data246 = copy(tags = t :: tags)
  def put(k: String, v: String): Data246 = copy(meta = meta.updated(k, v))
  def merge(other: Data246): Data246 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data246 {
  given Ordering[Data246] = Ordering.by(_.id)
  def empty: Data246 = Data246(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data246 =
    Data246(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data246] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
