package generated

final case class Data1305(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1305 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1305 = copy(value = value * k)
  def addTag(t: String): Data1305 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1305 = copy(meta = meta.updated(k, v))
  def merge(other: Data1305): Data1305 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1305 {
  given Ordering[Data1305] = Ordering.by(_.id)
  def empty: Data1305 = Data1305(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1305 =
    Data1305(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1305] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
