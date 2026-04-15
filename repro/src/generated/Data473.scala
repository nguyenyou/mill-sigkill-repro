package generated

final case class Data473(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data473 = copy(name = name.toUpperCase)
  def scale(k: Double): Data473 = copy(value = value * k)
  def addTag(t: String): Data473 = copy(tags = t :: tags)
  def put(k: String, v: String): Data473 = copy(meta = meta.updated(k, v))
  def merge(other: Data473): Data473 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data473 {
  given Ordering[Data473] = Ordering.by(_.id)
  def empty: Data473 = Data473(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data473 =
    Data473(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data473] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
