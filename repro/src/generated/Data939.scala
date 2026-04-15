package generated

final case class Data939(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data939 = copy(name = name.toUpperCase)
  def scale(k: Double): Data939 = copy(value = value * k)
  def addTag(t: String): Data939 = copy(tags = t :: tags)
  def put(k: String, v: String): Data939 = copy(meta = meta.updated(k, v))
  def merge(other: Data939): Data939 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data939 {
  given Ordering[Data939] = Ordering.by(_.id)
  def empty: Data939 = Data939(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data939 =
    Data939(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data939] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
