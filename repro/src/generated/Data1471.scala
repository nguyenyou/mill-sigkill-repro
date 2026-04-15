package generated

final case class Data1471(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1471 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1471 = copy(value = value * k)
  def addTag(t: String): Data1471 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1471 = copy(meta = meta.updated(k, v))
  def merge(other: Data1471): Data1471 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1471 {
  given Ordering[Data1471] = Ordering.by(_.id)
  def empty: Data1471 = Data1471(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1471 =
    Data1471(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1471] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
