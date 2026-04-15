package generated

final case class Data676(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data676 = copy(name = name.toUpperCase)
  def scale(k: Double): Data676 = copy(value = value * k)
  def addTag(t: String): Data676 = copy(tags = t :: tags)
  def put(k: String, v: String): Data676 = copy(meta = meta.updated(k, v))
  def merge(other: Data676): Data676 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data676 {
  given Ordering[Data676] = Ordering.by(_.id)
  def empty: Data676 = Data676(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data676 =
    Data676(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data676] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
