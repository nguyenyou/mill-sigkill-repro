package generated

final case class Data196(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data196 = copy(name = name.toUpperCase)
  def scale(k: Double): Data196 = copy(value = value * k)
  def addTag(t: String): Data196 = copy(tags = t :: tags)
  def put(k: String, v: String): Data196 = copy(meta = meta.updated(k, v))
  def merge(other: Data196): Data196 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data196 {
  given Ordering[Data196] = Ordering.by(_.id)
  def empty: Data196 = Data196(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data196 =
    Data196(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data196] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
