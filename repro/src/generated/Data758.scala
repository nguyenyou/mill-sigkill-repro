package generated

final case class Data758(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data758 = copy(name = name.toUpperCase)
  def scale(k: Double): Data758 = copy(value = value * k)
  def addTag(t: String): Data758 = copy(tags = t :: tags)
  def put(k: String, v: String): Data758 = copy(meta = meta.updated(k, v))
  def merge(other: Data758): Data758 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data758 {
  given Ordering[Data758] = Ordering.by(_.id)
  def empty: Data758 = Data758(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data758 =
    Data758(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data758] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
