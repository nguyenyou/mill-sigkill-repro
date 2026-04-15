package generated

final case class Data1417(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1417 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1417 = copy(value = value * k)
  def addTag(t: String): Data1417 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1417 = copy(meta = meta.updated(k, v))
  def merge(other: Data1417): Data1417 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1417 {
  given Ordering[Data1417] = Ordering.by(_.id)
  def empty: Data1417 = Data1417(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1417 =
    Data1417(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1417] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
