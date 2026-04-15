package generated

final case class Data391(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data391 = copy(name = name.toUpperCase)
  def scale(k: Double): Data391 = copy(value = value * k)
  def addTag(t: String): Data391 = copy(tags = t :: tags)
  def put(k: String, v: String): Data391 = copy(meta = meta.updated(k, v))
  def merge(other: Data391): Data391 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data391 {
  given Ordering[Data391] = Ordering.by(_.id)
  def empty: Data391 = Data391(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data391 =
    Data391(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data391] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
