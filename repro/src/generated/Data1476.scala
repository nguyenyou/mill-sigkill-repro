package generated

final case class Data1476(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1476 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1476 = copy(value = value * k)
  def addTag(t: String): Data1476 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1476 = copy(meta = meta.updated(k, v))
  def merge(other: Data1476): Data1476 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1476 {
  given Ordering[Data1476] = Ordering.by(_.id)
  def empty: Data1476 = Data1476(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1476 =
    Data1476(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1476] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
