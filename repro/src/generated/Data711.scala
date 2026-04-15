package generated

final case class Data711(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data711 = copy(name = name.toUpperCase)
  def scale(k: Double): Data711 = copy(value = value * k)
  def addTag(t: String): Data711 = copy(tags = t :: tags)
  def put(k: String, v: String): Data711 = copy(meta = meta.updated(k, v))
  def merge(other: Data711): Data711 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data711 {
  given Ordering[Data711] = Ordering.by(_.id)
  def empty: Data711 = Data711(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data711 =
    Data711(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data711] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
