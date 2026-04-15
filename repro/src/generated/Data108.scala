package generated

final case class Data108(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data108 = copy(name = name.toUpperCase)
  def scale(k: Double): Data108 = copy(value = value * k)
  def addTag(t: String): Data108 = copy(tags = t :: tags)
  def put(k: String, v: String): Data108 = copy(meta = meta.updated(k, v))
  def merge(other: Data108): Data108 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data108 {
  given Ordering[Data108] = Ordering.by(_.id)
  def empty: Data108 = Data108(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data108 =
    Data108(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data108] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
